import * as React from "react";
import AppBar from "@mui/material/AppBar";
import Box from "@mui/material/Box";
import Toolbar from "@mui/material/Toolbar";
import Typography from "@mui/material/Typography";
import Button from "@mui/material/Button";
import IconButton from "@mui/material/IconButton";
import { useNavigate } from "react-router-dom";

export default function ButtonAppBar() {
  const navigate = useNavigate();

  const handleButtonClick = () => {navigate('/reports')};
  const handleTitleClick = () => {
    navigate('/');
  }

  return (
    <Box sx={{ flexGrow: 1 }}>
      <AppBar position="static">
        <Toolbar>
          <IconButton
            size="large"
            edge="start"
            color="inherit"
            aria-label="menu"
            sx={{ mr: 2 }}
          ></IconButton>
          <Typography
            variant="h4"
            component="div"
            sx={{ flexGrow: 1 }}
            style={{ fontFamily: "Fasthand" }}
            onClick={handleTitleClick}
          >
            Dream Catch
          </Typography>
          <Button color="inherit" onClick={handleButtonClick}>
            Reports
          </Button>
        </Toolbar>
      </AppBar>
    </Box>
  );
}
