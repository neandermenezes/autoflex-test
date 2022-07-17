import { Route, Routes } from "react-router-dom";
import Products from "./pages/Products";
import './styles/App.css';

function App() {
  return (
    <div className="App">
      <Routes>
        <Route path="/" element={<Products />} />
      </Routes>
    </div>
  );
}

export default App;
