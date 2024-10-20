console.log("inside Contacts.js");

const viewContactModal = document.getElementById("view_contact_modal");


/*$(document).ready(function() {
	$('#contactModal').on('hidden.bs.modal', function() {
		location.reload(); 
	});
});*/

async function loadContactdata(id) {
	console.log("Loading data for contact with ID:", id);

	$.ajax({
		type: "GET",
		url: "/user/contacts/view/" + id,
		success: function(data) {
			// Update modal fields with the contact data
			$('#FirstName').text(data.firstName);  // Set text content for the label
			$('#LastName').text(data.lastName);
			$('#Email').text(data.email);
			$('#PhoneNo').text(data.phone);
			$('#Image').attr('src', data.image);  // For images, use .attr() to set the 'src' attribute
			/* $('#CreatedAt').text(data.createdAt);
			 $('#UpdatedAt').text(data.updatedAt);*/
			$('#Favorite').text(data.favorite ? "Yes" : "No");
			/*$('#CloudariryImageId').text(data.cloudinaryImagePublicId);*/

			$('#contactModal').modal('show');
		},
		error: function(error) {
			console.error("Error fetching contact data:", error);
		}
	});
}

async function deleteContact(id, firstName) {
    console.log(firstName);
    console.log("id is", id);

    const swalWithBootstrapButtons = Swal.mixin({
        customClass: {
            confirmButton: "btn btn-success",
            cancelButton: "btn btn-danger"
        },
        buttonsStyling: false
    });

    swalWithBootstrapButtons.fire({
        title: `Are you sure want to delete contact ${firstName}?`,
        text: `You won't be able to revert this action for contact ${firstName}!`,
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
            // Show the spinner
            $('#loadingSpinner').show();

            // Perform the deletion request
            fetch("/user/contacts/delete/" + id, {
                method: "DELETE"
            })
                .then(response => response.json())
                .then(data => {
                    // Hide the spinner after the deletion is complete
                    $('#loadingSpinner').hide();

                    // Show success alert
                    swalWithBootstrapButtons.fire({
                        title: "Deleted!",
                        text: `Contact ${firstName} has been removed.`,
                        icon: "success"
                    }).then(() => {
                        location.reload();
                    });
                })
                .catch(error => {
                    // Hide the spinner if an error occurs
                    $('#loadingSpinner').hide();

                    // Show an error alert if something went wrong
                    swalWithBootstrapButtons.fire({
                        title: "Error!",
                        text: "Something went wrong. Please try again.",
                        icon: "error"
                    });
                });
        } else if (result.dismiss === Swal.DismissReason.cancel) {
            // Show the canceled alert and hide the spinner
            $('#loadingSpinner').hide();

            swalWithBootstrapButtons.fire({
                title: "Cancelled",
                text: `Your contact ${firstName} is safe.`,
                icon: "error"
            });
        }
    });
}


let updateid;

function submitForm() {
	const firstName = $('#FirstNameUpdate').val();
	const lastName = $('#LastNameUpdate').val();
	const email = $('#EmailUpdate').val();
	const phone = $('#PhoneNoUpdate').val();
	const favorite = $('#FavoriteUpdate').is(':checked');
	const imageFile = $('#ImageUpdate')[0].files[0];

	// Client-side validation
	let validationErrors = [];

	// Validate First Name
	if (!firstName || firstName.length < 2 || firstName.length > 15) {
		validationErrors.push("First Name must be between 2 and 15 characters!!!");
	}

	// Validate Last Name
	if (!lastName || lastName.length < 2 || lastName.length > 10) {
		validationErrors.push("Last Name must be between 2 and 10 characters!!!");
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

	// Validate File Size (1MB limit)
	if (imageFile && imageFile.size > 1 * 1024 * 1024) {
		validationErrors.push("File size must not exceed 1 MB!!!");
	}

	// If validation errors exist, show them in a minimal SweetAlert alert
	if (validationErrors.length > 0) {
		let errorMessage = validationErrors.join('<br/>');
		Swal.fire({
			html: `<span style="color:red;">${errorMessage}</span>`,
			showConfirmButton: true,
			confirmButtonText: 'OK',
			customClass: {
				title: 'small-text',
				htmlContainer: 'small-text',
			}
		});
		return; // Stop form submission if there are validation errors
	}

	// Prepare FormData object
	const contactForm = new FormData();
	contactForm.append("firstName", firstName);
	contactForm.append("lastName", lastName);
	contactForm.append("email", email);
	contactForm.append("phone", phone);
	contactForm.append("favorite", favorite);

	if (imageFile) {
		contactForm.append("contactImage", imageFile);
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
			updateContact(updateid, contactForm); // Call the function to update contact
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
		url: "/user/contacts/update/view/" + id,
		success: function(data) {
			$('#FirstNameUpdate').val(data.firstName);
			$('#LastNameUpdate').val(data.lastName);
			$('#EmailUpdate').val(data.email);
			$('#PhoneNoUpdate').val(data.phone);
			$('#ImagePreview').attr('src', data.image);
			$('#FavoriteUpdate').prop('checked', data.favorite);
		},
		error: function(errormessage) {
			console.log(errormessage);
		}
	});
}

function updateContact(updateid, contactForm) {
	$.ajax({
		url: "/user/contacts/update/" + updateid,
		type: 'POST',
		data: contactForm,
		contentType: false, // Required for multipart/form-data
		processData: false, // Required for FormData handling
		success: function(result) {
			$('#updateContactModal').modal('hide');
			Swal.fire("Contact Updated Successfully!", "", "success").then(() => {
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
