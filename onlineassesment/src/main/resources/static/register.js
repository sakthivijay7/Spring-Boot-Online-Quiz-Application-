  // window load on Register Page
  window.onload=function(){
    console.log("Get message from register page");
    const message1=document.getElementById("mess1");
    const message2=document.getElementById("mess2");
   // registered success message and redirect to login
    if (message1){
    console.log("registered successfully");
    alert(message1.textContent);
    window.location.href="/login";
  }   
  // email already exists message and redirect to log in page
    if(message2){
     console.log("email exists")
     alert(message2.textContent);
     window.location.href="/login";
  }
}