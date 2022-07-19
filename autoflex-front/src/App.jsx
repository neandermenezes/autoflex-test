import { Route, Routes } from "react-router-dom";
import Products from "./pages/Products";
import Feedstocks from "./pages/Feedstocks";
import FeedstockProducts from "./pages/FeedstockProducts";
import "./styles/App.css";

function App() {
  return (
    <div className="App">
      <Routes>
        <Route path="/" element={<Products />} />
        <Route path="/feedstock" element={<Feedstocks />} />
        <Route path="/feedstock/products" element={<FeedstockProducts />} />
      </Routes>
    </div>
  );
}

export default App;
