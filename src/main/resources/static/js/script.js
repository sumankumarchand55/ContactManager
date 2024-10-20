console.log("inside script.js");

/* Auto-hide alert messages after 5 seconds */
window.setTimeout(() => {
    $(".alert").fadeTo(500, 0).slideUp(500, function () {
        $(this).remove();
    });
}, 5000);

/* Toggle password visibility */
document.addEventListener('DOMContentLoaded', function () {
    console.log("DOM fully loaded");

    const togglePassword = document.querySelector('#togglePassword');
    const password = document.querySelector('#password_field');

    if (togglePassword && password) {
        togglePassword.addEventListener('click', function () {
            // Toggle the type attribute
            const type = password.getAttribute('type') === 'password' ? 'text' : 'password';
            password.setAttribute('type', type);
            
            // Toggle the eye icon
            const icon = this.querySelector('i');
            if (icon) {
                icon.classList.toggle('fa-eye');
                icon.classList.toggle('fa-eye-slash');
            }
        });
    }

    /* FAQ section toggle functionality */
    document.querySelectorAll('.faq-question').forEach(question => {
        question.addEventListener('click', () => {
            const item = question.parentNode;
            const isActive = item.classList.contains('active');
            
            // Toggle the active class
            item.classList.toggle('active');

            // Get the answer element
            const answer = item.querySelector('.faq-answer');

            if (answer) {
                if (!isActive) {
                    // Smoothly open the answer
                    answer.style.maxHeight = answer.scrollHeight + 'px';
                } else {
                    // Smoothly close the answer
                    answer.style.maxHeight = null;
                }
            }
        });
    });

    const sidebarToggle = document.getElementById('sidebarToggle');
    const sidebar = document.getElementById('sidebar');

    if (sidebarToggle && sidebar) {
        sidebarToggle.addEventListener('click', function () {
            sidebar.classList.toggle('active');
        });
    }

    window.onload = function () {
        const currentPath = window.location.pathname;
        const sidebarToggle = document.getElementById('sidebarToggle');

        if (sidebarToggle) {
            if (currentPath.startsWith('/user')) {
                sidebarToggle.style.display = 'block';
            } else {
                sidebarToggle.style.display = 'none';
            }
        }
    };
});

const navbarTogglerBeforeLogin = document.getElementById('navbarTogglerBeforeLogin');
if (navbarTogglerBeforeLogin) {
  const iconBeforeLogin = navbarTogglerBeforeLogin.querySelector('span');
  if (iconBeforeLogin) {
    navbarTogglerBeforeLogin.addEventListener('click', function() {
      if (iconBeforeLogin.classList.contains('fa-angle-down')) {
        iconBeforeLogin.classList.remove('fa-angle-down');
        iconBeforeLogin.classList.add('fa-angle-up');
      } else {
        iconBeforeLogin.classList.remove('fa-angle-up');
        iconBeforeLogin.classList.add('fa-angle-down');
      }
    });
  }
}

document.addEventListener('DOMContentLoaded', function() {
  const navbarToggler = document.getElementById('navbarToggler');
  if (navbarToggler) {
    const icon = navbarToggler.querySelector('span');

    navbarToggler.addEventListener('click', function() {
      if (icon.classList.contains('fa-angle-down')) {
        icon.classList.remove('fa-angle-down');
        icon.classList.add('fa-angle-up');
      } else {
        icon.classList.remove('fa-angle-up');
        icon.classList.add('fa-angle-down');
      }
    });
  }
});
