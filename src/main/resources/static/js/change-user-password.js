let updatepasswordid;

function update_password(id) {
	updatepasswordid = id;
	console.log(id);
}


function submitChangePassword() {
    const currentPassword = $('#currentPassword').val();
    const newPassword = $('#newPassword').val();
    const confirmPassword = $('#confirmPassword').val();

    let validationErrors = [];

    if (!currentPassword || currentPassword.length < 6) {
        validationErrors.push("Current password must be at least 6 characters long!!!");
    }

    if (!newPassword || newPassword.length < 6) {
        validationErrors.push("New password must be at least 6 characters long!!!");
    }

    if (newPassword !== confirmPassword) {
        validationErrors.push("New password and confirm password do not match!!!");
    }

    if (validationErrors.length > 0) {
        let errorMessage = validationErrors.join('<br/>');
        Swal.fire({
            html: `<span style="color:red;">${errorMessage}</span>`,
            showConfirmButton: true,
            confirmButtonText: 'OK',
        });
        return;
    }

    const changePasswordForm = {
        currentPassword: currentPassword,
        newPassword: newPassword,
        confirmPassword: confirmPassword
    };

    Swal.fire({
        title: "Are you sure want to change the password?",
        showDenyButton: true,
        showCancelButton: true,
        confirmButtonText: "Yes, Change",
        denyButtonText: "Don't Change"
    }).then((result) => {
        if (result.isConfirmed) {
            $('#loadingSpinner').show();
            updatePassword(updatepasswordid, changePasswordForm);
        } else if (result.isDenied) {
            Swal.fire("Password change cancelled", "", "info");
        }
    });
}

function updatePassword(userId, changePasswordForm) {
    $.ajax({
        url: "/user/change-password/" + userId,
        type: "POST",
        data: changePasswordForm,
        success: function(response) {
            Swal.fire("Password Updated Successfully!", "", "success").then(() => {
                $('#changePasswordModal').modal('hide');
                location.reload();
            });
        },
        error: function(errormessage) {
            if (errormessage.status === 400) {
                Swal.fire({
                    icon: "error",
                    title: '<span style="color:red;">ERROR !!</span>',
                    text: errormessage.responseText,
                    showConfirmButton: true,
                    confirmButtonText: 'OK',
                });
            } else {
                Swal.fire({
                    icon: "error",
                    title: '<span style="color:red;">ERROR !!</span>',
                    text: "An unexpected error occurred. Please try again later.",
                    showConfirmButton: true,
                    confirmButtonText: 'OK',
                });
            }
            console.log(errormessage);
        },
        complete: function() {
            $('#loadingSpinner').hide();
        }
    });
}


$(document).ready(function() {
    $('#toggleCurrentPassword').on('click', function() {
        const currentPasswordField = $('#currentPassword');
        const type = currentPasswordField.attr('type') === 'password' ? 'text' : 'password';
        currentPasswordField.attr('type', type);
        $(this).find('i').toggleClass('fa-eye fa-eye-slash');
    });

    $('#toggleNewPassword').on('click', function() {
        const newPasswordField = $('#newPassword');
        const type = newPasswordField.attr('type') === 'password' ? 'text' : 'password';
        newPasswordField.attr('type', type);
        $(this).find('i').toggleClass('fa-eye fa-eye-slash');
    });

    $('#toggleConfirmPassword').on('click', function() {
        const confirmPasswordField = $('#confirmPassword');
        const type = confirmPasswordField.attr('type') === 'password' ? 'text' : 'password';
        confirmPasswordField.attr('type', type);
        $(this).find('i').toggleClass('fa-eye fa-eye-slash');
    });
});
