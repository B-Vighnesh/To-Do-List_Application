import { Routes, Route } from "react-router-dom";
import Dashboard from './components/Dashboard.jsx';
import About from './components/About.jsx';

export default function AppRoutes() {
  return (
    <Routes>
        <Route path='/' element={<Dashboard />}></Route>
        <Route path='/about' element={<About />}></Route>

    </Routes>
  )
}