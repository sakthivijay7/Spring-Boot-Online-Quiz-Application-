   // window lode than answer submission and redirect to main page
   window.onload=function(){
      console.log("quiz page to submit score");

      const email=localStorage.getItem("saveemail");
      console.log("email got");
       if (!email){
         alert("email not found back to start test");
       }
      console.log("start to Quiz button click")
      const submitButton = document.getElementById("quizbutton");

    // Add a click event listener to the submit button
     if (submitButton) {
      submitButton.addEventListener("click", function() {
      console.log("Submit button clicked - score calculating...");
      let answers=
      { q1:"Malayalam", q2:"Tuple", q3:"Interpreted", q4:"Simple", q5:"__",
        q6:"Ds&AI", q7:"def", q8:"pandas", q9:"flask", q10:"scrap", 

        q11:"Malayalam", q12:"Tuple", q13:"OOP", q14:"Faster", q15:"private",
        q16:"Mobile", q17:"void", q18:"util", q19:"spring", q20:"dbconnection"};

       let score=0;
       for(key in answers){
           selected=document.querySelector(`input[name='${key}']:checked`);
           console.log("Selected answers: " + selected);
           if(selected && selected.value==answers[key]){
            score++;
           }
        }
        console.log("before fetch score:" + score);
      
       fetch("http://localhost:8080/test",{
       method:"POST",
       headers:{
        "Content-Type":"application/json"},
        body:JSON.stringify({email:email,score:score})
       })
       .then(res=>res.text())
       .then(data =>{
         console.log("score submitted!");

         if (score==10){
          alert("Score "+ score + "Excellent"+data);
          window.location.href="/test";
         }
         else if(score>8 && score!=10){
         alert("Score "+ score +" Well done:");
         window.location.href="/test";
        }
         else{
          alert("Score "+score+"Retry") ;
          window.location.href="/test";
         }
         })
  
         .catch(err =>
            console.console.error("Error"+err));

      }
    )
  }
}

    