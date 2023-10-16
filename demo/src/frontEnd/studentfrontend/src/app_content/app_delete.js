import Input from './snippets/input'
import { requestFetch } from './app_list.js';

function Delete({handleListReload}) {

  const fetchData = requestFetch(handleListReload)

    
  async function handleDelete(id) {

    if(id < 1){
      window.alert("No negativ ID's exist");
    }
    try {
      const response = await fetch(`http://localhost:8080/delete/${id}`, {
        method: "DELETE",
        headers: {
          "Content-Type": "application/json",
        }
      });


      console.log(response);
      if (response.status === 201 || response.status === 200) {
        window.alert("Your request was successful!");
        fetchData()
      } else {
        window.alert(`An error has occured status: ${response.status}`);
      }
    } catch (error) {
      console.log(error);
    }
  }
  

  return (
    <div className="delete" id="Delete">
        <Input  labelText={"StudentID"} id={"delete"} inputType={"number"}  min="1"/>
        <button type="submit" onClick={() => handleDelete(document.querySelector("#delete").value)}>delete</button>
    </div>
  );
}

export default Delete;
