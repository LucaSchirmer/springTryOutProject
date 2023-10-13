import Input from './snippets/input'

function Add() {
  

  const handleSubmit = async () =>{

    const inputs = document.querySelectorAll("input");
    
    let inputContent = [];
    inputs.forEach(input=>{
      if(input.value !== undefined && input.value != null  && input.value !== ""){
        inputContent.push(input.value);
      }
    })

    let jsonContent = {"name": inputContent[0], "email": inputContent[1], "dob": inputContent[2]};

    console.log(jsonContent)
    const response = await fetch("http://localhost:8080/addStudent", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(jsonContent)
    });


    
    if (response.status === 201) {
      const data = await response.json();
      console.log(data);
    } else {
      window.alert("An error has occured")
    }
  }

  return (
    <div className="add">
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
