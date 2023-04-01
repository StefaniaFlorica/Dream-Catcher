import { useEffect, useState } from "react";
import Header from "./Header";
import SleepMetricsService from "../services/SleepMetricsService";
import {
  FormControl,
  InputLabel,
  MenuItem,
  Select,
  FormHelperText,
  Grid,
  Button,
} from "@mui/material";
import BarChart from "./BarChart";
import { Bar } from "react-chartjs-2";

function Reports() {
  const [type, setType] = useState("");
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

  const handleChange = (event) => {
    setType(event.target.value);
  };

    useEffect(() => {
        if(data!=null)
        {
            console.log("data has changed: ", chartData);
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
      
    }, [data]);

  const handleButtonClick = (event) => {
    if(type==="")
    {
        alert("Please select a report type!");
        return
    }
    SleepMetricsService.generateReport(type)
      .then((res) => res.data)
      .then((data1) => {
        setData(data1);
        // setChartData({
        //             labels: ['1','2','3','4','5','6','7'],
        //             datasets: [
        //               {
        //                 label: type,
        //                 data: Object.values(data),
        //                 borderColor: "black",
        //                 borderWidth: 2,
        //               },
        //             ],
        //           });
        
      });
      
    // 
  };

  return (
    <div
      style={{
        display: "flex",
        alignItems: "center",
        justifyContent: "center",
        padding: 20,
      }}
    >
      <Grid justify="center" alignItems="center" direction="column">
        <Header text="Generate report" />
        <FormControl sx={{ m: 1, minWidth: 120 }}>
          <InputLabel id="demo-simple-select-helper-label">Type</InputLabel>
          <Select
            labelId="demo-simple-select-helper-label"
            id="demo-simple-select-helper"
            value={type}
            label="Type"
            onChange={handleChange}
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
          <FormHelperText>Select only ONE category</FormHelperText>
        </FormControl>
        <div>
          <Button
            variant="contained"
            style={{ marginLeft: 100 }}
            onClick={handleButtonClick}
          >
            Generate
          </Button>
        </div>
        <div>{isShown ? <Bar data={chartData} /> : <p></p>}</div>
      </Grid>
    </div>
  );
}

export default Reports;
