import { useEffect, useState, useRef } from "react";
import Header from "./Header";
import SleepMetricsService from "../services/SleepMetricsService";
import {
  FormControl,
  InputLabel,
  MenuItem,
  Select,
  Grid,
  Button,
} from "@mui/material";
import { Bar } from "react-chartjs-2";
import "chart.js/auto"; // ADD THIS

function Reports() {
  const ref = useRef();

  const sleepMetricsService = new SleepMetricsService();
  const [type, setType] = useState("");
  const [frequency, setFrequency] = useState("");
  const [isShown, setIsShown] = useState(false);
  const [data, setData] = useState(null);
  const [chartData, setChartData] = useState({
    labels: ["Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"],
    datasets: [
      {
        label: [],
        data: [],
        borderColor: "black",
        borderWidth: 2,
      },
    ],
  });

  const reportTypes = ["duration", "energy", "stress"];
  const frequencyTypes = ["weekly", "monthly"];

  const handleChangeType = (event) => {
    setType(event.target.value);
  };
  const handleChangeFrequency = (event) => {
    setFrequency(event.target.value);
  };

  useEffect(() => {
    if (data != null) {
      // console.log("data has changed: ", chartData);
      setChartData({
        labels: ["Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"],
        datasets: [
          {
            label: type,
            data: Object.values(data),
            borderColor: "black",
            borderWidth: 2,
          },
        ],
      });
      setIsShown(true);
    }
  }, [data, type, frequency]);

  const handleButtonClick = (event) => {
    if (type === "" || frequency === "") {
      alert("Please pick a choice for each category!");
      return;
    }
    sleepMetricsService
      .generateReport(frequency, type)
      .then((res) => res.data)
      .then((data1) => {
        setData(data1);
      })
      .catch((err) => console.log(err));
  };

  return (
    <div
      style={{
        display: "flex",
        alignItems: "center",
        justifyContent: "center",
        flexDirection: "column",
        padding: 20,
      }}
    >
      <Grid justify="center" alignItems="center">
        <Header text="Generate report" />
        <FormControl sx={{ m: 1, minWidth: 120 }}>
          <InputLabel id="demo-simple-select-helper-label">Type</InputLabel>
          <Select
            labelId="demo-simple-select-helper-label"
            id="demo-simple-select-helper"
            value={type}
            label="Type"
            onChange={handleChangeType}
            style={{ width: 300 }}
          >
            <MenuItem value="">
              <em></em>
            </MenuItem>
            {reportTypes.map((name) => (
              <MenuItem key={name} value={name}>
                {name}
              </MenuItem>
            ))}
          </Select>
        </FormControl>
        <FormControl sx={{ m: 1, minWidth: 120 }}>
          <InputLabel id="demo-simple-select-helper-label2">
            Frequency
          </InputLabel>
          <Select
            labelId="demo-simple-select-helper-label2"
            id="demo-simple-select-helper2"
            value={frequency}
            label="Frequency"
            onChange={handleChangeFrequency}
            style={{ width: 300 }}
          >
            <MenuItem value="">
              <em></em>
            </MenuItem>
            {frequencyTypes.map((name) => (
              <MenuItem key={name} value={name}>
                {name}
              </MenuItem>
            ))}
          </Select>
        </FormControl>
        <div
          style={{
            justifyContent: "center",
            alignItems: "center",
            flexDirection: "column",
          }}
        >
          <Button
            variant="contained"
            style={{ marginLeft: 250 }}
            onClick={handleButtonClick}
          >
            Generate
          </Button>
        </div>
        <div>{isShown ? <Bar ref={ref} data={chartData} /> : <p></p>}</div>
      </Grid>
    </div>
  );
}

export default Reports;
