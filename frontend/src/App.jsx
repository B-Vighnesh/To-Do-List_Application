import Navbar from "./components/Navbar";
import Footer from "./components/Footer";
import { Outlet } from "react-router-dom";
import AppRoutes from "./router";
export default function App() {
  return (
    <div className="app">
      <Navbar />

      <main className="main-container">
        <Outlet />
      </main>
      <AppRoutes />

      <Footer />
    </div>
    
  );
  return <AppRoutes/>;
}
