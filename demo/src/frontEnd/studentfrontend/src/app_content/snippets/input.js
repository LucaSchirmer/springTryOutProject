
function Input({labelText, id, inputType="text"}) {


  return (
    <div className="inputContainer">
        <label>
            {labelText}
        </label>
        <input type={inputType} id={id}>
            
        </input>
    </div>
  );
}

export default Input;
