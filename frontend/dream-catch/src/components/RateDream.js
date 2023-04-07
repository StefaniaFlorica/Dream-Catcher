import { Box, Button, Rating } from "@mui/material";
import React, { useState, useRef, useEffect } from "react";
import DreamService from "../services/DreamService";
import SleepMetricsService from "../services/SleepMetricsService";
import { useNavigate } from "react-router-dom";
import Header from "./Header";

export default function RateDream(dreamProp) {
  const [data, setData] = useState({
    durationLevel: 0,
    energyLevel: 0,
    stressLevel: 0,
  });
  const [isSaved, setIsSaved] = useState(false);

  const navigate = useNavigate();

  const handleInputChange = (event) => {
    setData({ ...data, [event.target.name]: parseInt(event.target.value) });
  };

  function handleSubmit(event) {
    event.preventDefault();
    alert(JSON.stringify(data, undefined, 2));
  }

  function handleClick(event) {
    if(data.durationLevel === 0 || data.energyLevel === 0 || data.stressLevel === 0)
    {
      alert("Please evaluate ALL metrics");
      return;
    }
    const metricsRequestBody = {
      durationLevel: data.durationLevel,
      energyLevel: data.energyLevel,
      stressLevel: data.stressLevel,
    };
    DreamService.updateDream(metricsRequestBody, dreamProp.dreamData.id)
      .then((res) => res.data)
      .then((dbData) => {
        setData(dbData);
        setIsSaved(true);
      })
      .catch((err) => console.log(err));

    navigate("/");
  }

  // useEffect(() => {
  // }, [dreamProp.dream, data]);

  return (
    <div
      style={{
        display: "flex",
        alignItems: "center",
        justifyContent: "center",
        padding: 20,
      }}
    >
      <form onSubmit={(e) => handleSubmit(e)}>
        <table>
          <tr>
            <Header text="Evaluate " />
          </tr>
          <tr>
            <div>
              <div id="duration_rating">Duration</div>
              <Rating
                disable={isSaved}
                name="durationLevel"
                value={data.durationLevel}
                size="large"
                onChange={handleInputChange}
              />
            </div>
          </tr>
          <tr>
            <div>
              <div id="energy_rating">Energy</div>
              <Rating
                disable={isSaved}
                name="energyLevel"
                value={data.energyLevel}
                size="large"
                onChange={handleInputChange}
              />
            </div>
          </tr>
          <tr>
            <div>
              <div id="stress_rating">Stress</div>
              <Rating
                disable={isSaved}
                name="stressLevel"
                value={data.stressLevel}
                size="large"
                onChange={handleInputChange}
              />
            </div>
          </tr>
          <Box textAlign="center">
            <Button
              disable={isSaved}
              variant="contained"
              style={{ marginTop: 20 }}
              onClick={handleClick}
            >
              Save
            </Button>
          </Box>
        </table>
      </form>
    </div>
  );
}
