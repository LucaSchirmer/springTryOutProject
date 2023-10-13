import Input from './snippets/input'

function Add() {
  

  const handleSubmit = async () =>{

    const inputs = document.querySelectorAll("input");
    
    let inputContent = [];
    inputs.forEach(input=>{
      if(input.id === "delete"){
        return;
      }
      
      if(input.value !== undefined && input.value != null  && input.value !== ""){
        inputContent.push(input.value);
      }
    })

    let jsonContent = {"name": inputContent[0], "email": inputContent[1], "dob": inputContent[2]};

    console.log(jsonContent)
    try {
      const response = await fetch("http://localhost:8080/addStudent", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(jsonContent)
      });
  
  
      console.log(response)
      if (response.status === 201) {
        window.alert("Your request was successful!")
      } else {
        window.alert(`An error has occured status: ${response.status}`)
      }
    } catch (error) {
      console.log(error);
    }
  }

  return (
    <div className="add" id="Add">
      <div className="containerAdd">
        <Input  labelText={"Name"} id={"name"} />
        <Input  labelText={"Email"} id={"email"} />
        <Input  labelText={"Geburtsdatum"} id={"dob"} inputType={"Date"} />
      </div>
        <button type="submit" onClick={handleSubmit}>submit</button>
    </div>
  );
}

export default Add;
