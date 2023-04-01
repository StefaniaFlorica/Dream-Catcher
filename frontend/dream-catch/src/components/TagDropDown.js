import * as React from "react";
import { FormControl, Select } from "@mui/material";

export default function TagDropDown(props) {
  const [loading, setLoading] = React.useState(false);
  const [items, setItems] = React.useState([
    { id: 4, name: "Animals" },
    {
      label: "Family",
      key: "1",
    },
    {
      label: "Lucid Dream",
      key: "2",
    },
    {
      label: "Nature",
      key: "3",
    },
    {
      label: "Nightmare",
      key: "6",
    },
  ]);
  const [value, setValue] = React.useState();


  // React.useEffect(() => {
    // let unmounted = false;
    //   async function getTags() {
    //     const response = await fetch("http://api/tagService/getTags");
    //     const body = await response.json();
    //     if (!unmounted) {
    //       setItems(
    //         body.results.map(({ id, name }) => ({ label: name, value: id }))
    //       );
    //       setLoading(false);
    //     }
    //   }
    //   getTags();
    //   console.log(items);

    //   return () => {
    //     unmounted = true;
    //   };
  // });

  return (
    <div>
      <label style={{ marginRight: 155 }}>Choose a tag</label>
      <select
        required
        style={{ width: 150, padding: 5 }}
        disabled={loading}
        value={value}
        onChange={(e) => {
          let index = e.nativeEvent.target.selectedIndex;
          let label1 = e.nativeEvent.target[index].text;
          let val = e.target.value;
          setValue(val);
          props.handleCallback([{ name: label1 }]);
        }}
      >
        {items.map(({ label, value }) => (
          <option key={label} value={value}>
            {label}
          </option>
        ))}
      </select>
    </div>
  );
}
