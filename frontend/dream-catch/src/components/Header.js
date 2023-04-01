import * as React from "react";
import Typography from "@mui/material/Typography";
import { useNavigate } from "react-router-dom";

export default function Header(props) {
  return (
    <div>
      <Typography
        variant="h2"
        color="#4169E1"
        align="center"
        component="div"
        sx={{ flexGrow: 1 }}
        style={{ fontFamily: "Fasthand", marginTop: 150 }}
      >
        {props.text}
      </Typography>
    </div>
  );
}
