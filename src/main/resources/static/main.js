   window.addEventListener("load",function(){
    console.log("login details pass to the main page");
       // user information set in the main page
    let uname=document.getElementById("username").textContent;
    let gender=document.getElementById("usergender").textContent;
    let email=document.getElementById("useremail").textContent;
    let phone=document.getElementById("userphone").textContent;

         // store all values locally
    if (email){
    console.log("user information saving ...")

    localStorage.setItem("savename", uname);
    localStorage.setItem("savegender", gender);
    localStorage.setItem("saveemail", email);
    localStorage.setItem("savephone", phone);

    console.log("user information to be saved!");
  }else{
    console.log("no values return");
    // window.location.href="/login";
  }
} )  


     // retake or back function
window.addEventListener("load", function() {
    console.log("Page loaded. Handling user details.");

    //  load saved user information 
    let savedUname = localStorage.getItem("savename");
    let savedGender = localStorage.getItem("savegender");
    let savedEmail = localStorage.getItem("saveemail");
    let savedPhone = localStorage.getItem("savephone");

    if (savedUname) {
        // If saved data exists
        console.log("Loading saved user information.");
         let uname=document.getElementById("username");
         let gender=document.getElementById("usergender");
         let email=document.getElementById("useremail");
        let phone=document.getElementById("userphone");
        
        if (email) {
            uname.textContent = savedUname;
            gender.textContent=savedGender;
            email.textContent=savedEmail;
            phone.textContent=savedPhone;
        }
    } else {
        // If no saved data found
        console.log("No saved user information found");
    }})