function copyToClipboard() {
				var copyText = document.getElementById("userUuid").textContent;

				var tempInput = document.createElement("input");
				tempInput.style = "position: absolute; left: -1000px; top: -1000px";
				tempInput.value = copyText;
				document.body.appendChild(tempInput);
				tempInput.select();
				document.execCommand("copy");
				document.body.removeChild(tempInput);

				alert("UUID copied to clipboard: " + copyText);
			}



let updateid;

function submitForm() {
	const name = $('#FirstNameUpdate').val();
	const email = $('#EmailUpdate').val();
	const phone = $('#PhoneNoUpdate').val();
	const dob = $('#DobUpdate').val();
	const about = $('#AboutUpdate').val();
	const imageFile = $('#ImageUpdate')[0].files[0];

	// Client-side validation
	let validationErrors = [];

	// Validate Name
	if (!name || name.length < 2 || name.length > 20) {
		validationErrors.push("Name must be between 2 and 20 characters!!!");
	}

	// Validate Email
	const emailPattern = /^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,6}$/;
	if (!email || !emailPattern.test(email)) {
		validationErrors.push("Invalid email address format!!!");
	}

	// Validate Phone
	const phonePattern = /^[0-9]{10}$/;
	if (!phone || !phonePattern.test(phone)) {
		validationErrors.push("Phone number must be 10 digits long!!!");
	}

	// Validate D.O.B
	if (!dob) {
		validationErrors.push("Date of Birth is required!!!");
	}

	// Validate About
	if (!about || about.length < 10) {
		validationErrors.push("About must contain at least 10 characters!!!");
	}

	// Validate File Size (1MB limit)
	if (imageFile && imageFile.size > 1 * 1024 * 1024) {
		validationErrors.push("File size must not exceed 1 MB!!!");
	}

	// If validation errors exist, show them in a SweetAlert alert
	if (validationErrors.length > 0) {
		let errorMessage = validationErrors.join('<br/>');
		Swal.fire({
			html: `<span style="color:red;">${errorMessage}</span>`,
			showConfirmButton: true,
			confirmButtonText: 'OK',
		});
		return; // Stop form submission if there are validation errors
	}

	// Prepare FormData object
	const userForm = new FormData();
	userForm.append("name", name);
	userForm.append("email", email);
	userForm.append("phoneNumber", phone);
	userForm.append("dob", dob);
	userForm.append("about", about);

	if (imageFile) {
		userForm.append("userImage", imageFile);
	}

	// Ask for confirmation before saving
	Swal.fire({
		title: "Do you want to save the changes?",
		showDenyButton: true,
		showCancelButton: true,
		confirmButtonText: "Save",
		denyButtonText: "Don't save"
	}).then((result) => {
		if (result.isConfirmed) {
			$('#loadingSpinner').show();
			updateUser(updateid, userForm); // Call the function to update user
		} else if (result.isDenied) {
			Swal.fire("Changes are not saved", "", "info");
		}
	});
}

function previewImage(input) {
	if (input.files && input.files[0]) {
		const reader = new FileReader();
		reader.onload = function(e) {
			$('#ImagePreview').attr('src', e.target.result);
		}
		reader.readAsDataURL(input.files[0]);
	}
}

function get_details(id) {
	updateid = id;
	$.ajax({
		type: "GET",
		url: "/user/update/view/" + id,
		success: function(data) {
			$('#FirstNameUpdate').val(data.name);
			$('#EmailUpdate').val(data.email);
			$('#PhoneNoUpdate').val(data.phoneNumber);
			$('#DobUpdate').val(data.dob);
			$('#AboutUpdate').val(data.about);
			$('#ImagePreview').attr('src', data.imageUrl);
		},
		error: function(errormessage) {
			console.log(errormessage);
		}
	});
}

function updateUser(updateid, userForm) {
	$.ajax({
		url: "/user/update/" + updateid,
		type: 'POST',
		data: userForm,
		contentType: false, // Required for multipart/form-data
		processData: false, // Required for FormData handling
		success: function(result) {
			$('#updateUserModal').modal('hide');
			Swal.fire("User Updated Successfully!", "", "success").then(() => {
				location.reload(); // Reload the page after user clicks "OK"
			});
		},
		error: function(errormessage) {
			Swal.fire({
				icon: "error",
				title: '<span style="color:red;">ERROR !!</span>',
				text: "An unexpected error occurred. Please try again later.",
				showConfirmButton: true,
				confirmButtonText: 'OK',
			});
			console.log(errormessage);
		},
		complete: function() {
			$('#loadingSpinner').hide(); // Hide spinner after completion
		}
	});
}

function exportToPdf() {
                const { jsPDF } = window.jspdf;
                const doc = new jsPDF();
                
                // Create PDF document from table
                doc.text("User Profile", 14, 16);
                
                doc.autoTable({
                    html: '#hiddenTableUser',
                    startY: 22,
                    theme: 'grid'
                });
                doc.save("user-profile.pdf");
            }
			

  async function disableUser(id,name) {
			 console.log("name is",name);
		  console.log("id is", id);
		   const swalWithBootstrapButtons = Swal.mixin({
			        customClass: {
			            confirmButton: "btn btn-success",
			            cancelButton: "btn btn-danger"
			        },
			        buttonsStyling: false
			    });
			    swalWithBootstrapButtons.fire({
			        title: `Are you sure want to disable account ${name}?`,
			        text: `You will again enable your account ${name}!`,
			        icon: "warning",
			        showCancelButton: true,
			        confirmButtonText: "YES",
			        cancelButtonText: "NO",
			        reverseButtons: true,
			        customClass: {
			            actions: 'my-actions',
			            cancelButton: 'btn btn-danger',
			            confirmButton: 'btn btn-success'
			        }
			    }).then((result) => {
			        if (result.isConfirmed) {
			            $('#loadingSpinner').show();
			            fetch("/user/disable/" + id, {
			                method: "POST"
			            })
			                .then(response => response.json())
			                .then(data => {
			                    $('#loadingSpinner').hide();
			                    swalWithBootstrapButtons.fire({
			                        title: "Disabled!",
			                         text: `User ${name} has been disabled. You will be logged out.`,
			                        icon: "success"
			                    }).then(() => {
			                         window.location.href = "/logout";
			                    });
			                })
			        } else if (result.dismiss === Swal.DismissReason.cancel) {
			            $('#loadingSpinner').hide();
			            swalWithBootstrapButtons.fire({
			                title: "Cancelled",
			                text: `User ${name} is safe.`,
			                icon: "error"
			            });
			        }
			    });
			}			