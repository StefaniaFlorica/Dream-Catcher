import React, { useState, useEffect } from "react";
import { Button, TextField, Box } from "@mui/material";
import TagDropDown from "./TagDropDown";
import { LocalizationProvider, DatePicker } from "@mui/x-date-pickers";
import { AdapterDayjs } from "@mui/x-date-pickers/AdapterDayjs";
import { useNavigate } from "react-router-dom";
import DreamService from "../services/DreamService";
import Header from "./Header";
import { useForm } from "react-hook-form";

function AddDream({ setDreamProp }) {
  const [dream, setDream] = useState({
    id: 0,
    description: "",
    date: "",
    tags: [],
    sleepMetrics: "",
  });


  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm();

  const onSubmit = (event) => {
    if (dream.date === "") {
      alert("Please select a date!")
      return;
    }
    const dreamRequestBody = {
      description: dream.description,
      date: dream.date,
      tags: dream.tags,
    };
  
    DreamService.createDream(dreamRequestBody)
      .then((res) => res.data)
      .then((data) => {
        setDream({
          ...dream,
          id: data.id,
          sleepMetrics: data.sleepMetrics,
        });
        setDreamProp(data);
        navigate("/rate");
      })
      .catch((err) => console.log(err));
  };

  const navigate = useNavigate();

  useEffect(() => {
    console.log("state has changed: ", dream);
  }, []);

  function callbackDropDown(childData) {
    setDream({ ...dream, tags: childData });
    setDreamProp(dream);
  }
  const handleInputChange = (event) => {
    setDream({ ...dream, [event.target.name]: event.target.value });
    setDreamProp({ ...dream, [event.target.name]: event.target.value });
  };

  function handleClick(event) {}

  return (
    <div
      style={{
        display: "flex",
        alignItems: "center",
        justifyContent: "center",
        padding: 20,
      }}
    >
      <form onSubmit={handleSubmit(onSubmit)}>
        <LocalizationProvider dateAdapter={AdapterDayjs}>
          <table>
            <tr>
              <Header text="About your dream" />
            </tr>
            <tr>
              <TextField
                name="description"
                sx={{ width: 400 }}
                id="outlined-multiline-static"
                label="Enter your dream description"
                multiline
                rows={4}
                defaultValue=""
                style={{ marginTop: 10, marginBottom: 20 }}
                autoFocus
                {...register("description", {
                  required: "Required field",
                })}
                error={!!errors?.description}
                helperText={
                  errors?.description ? errors.description.message : null
                }
                onChange={handleInputChange}
              />
            </tr>
            <tr>
              <DatePicker
                required
                name="date"
                sx={{ width: 400, marginBottom: 2 }}
                label="Choose dream date"
                autoFocus
                disableFuture
                onChange={(date) => {
                  const d = new Date(date).toLocaleDateString("en-CA");
                  setDream({ ...dream, date: d });
                  setDreamProp(dream);
                }}
              />
              
            </tr>
            <tr>
              <TagDropDown
                name="tags"
                handleCallback={callbackDropDown}
                onChange={handleInputChange}
              />
            </tr>
            <tr>
              <Box textAlign="center">
                <Button
                  type="submit"
                  variant="contained"
                  style={{ marginTop: 20 }}
                  // onClick={(e) => handleClick(e)}
                >
                  Submit
                </Button>
              </Box>
            </tr>
          </table>
        </LocalizationProvider>
      </form>
    </div>
  );
}

export default AddDream;
