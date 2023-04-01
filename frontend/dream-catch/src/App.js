import "./App.css";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import { useState } from "react";
import Header from "./components/Header";
import AddDream from "./components/AddDream";
import background from "./images/background.jpg";
import RateDream from "./components/RateDream";

import ButtonAppBar from "./components/ButtonAppBar";
import Reports from "./components/Reports";

function App() {
  const [dream, setDream] = useState({
    id: 0,
    description: "",
    date: "",
    tags: [],
    sleepMetrics: []
  });
  return (
    <div>
      <Router>
        <ButtonAppBar/>
        <Routes>
          <Route path="/" element={<AddDream setDreamProp={setDream} />} />
          <Route path="/rate" element={<RateDream dreamData={dream} />} />
          <Route path="/reports" element={<Reports />} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;
