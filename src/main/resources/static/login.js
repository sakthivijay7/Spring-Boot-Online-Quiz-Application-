    // window loading 
window.onload= function(){
    console.log("login message retrive");

    const message1=document.getElementById("message1");
    const message2=document.getElementById("message2");
    const message3=document.getElementById("message3");
            
        // no email exits message and redirect register page
    if (message1) {
        console.log("no emailexist in login page");
        alert(message1.textContent);
        window.location.href="/register";
    }
        // login success message and redirect to main
    if (message2) { 
        console.log("login successfully");
        alert(message2.textContent); 
        window.location.href="/test";
    }
         //password wrong message
    if (message3) { 
        alert(message3.textContent); 
     }
}    
