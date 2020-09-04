function loggoff() {
    sessionStorage.setItem("logged", false);
    sessionStorage.setItem("useremail", null);
   // sessionStorage.setItem("username", null);
    location.href = "loggedoff.html";
}
