import React, { useState } from 'react';
import Add from "./app_add";
import List from "./app_list";
import Delete from "./app_delete";

function Body() {

  const [listReload, setListReload] = useState(false);

    const handleListReload = () => {
      setListReload(!listReload);
    };

  return (
    <div>
      <Add onListReload={handleListReload} />
      <List key={listReload} /> {/* Using a unique key to force re-render */}
      <Delete onListReload={handleListReload} />
    </div>
  );
}

export default Body;
