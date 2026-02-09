import { Routes, Route } from "react-router-dom";
import Dashboard from './components/Dashboard.jsx';
import About from './components/About.jsx';
import App from './App.jsx'
export default function AppRoutes() {
  return (
    <Routes>
      <Route element={<App />}/>
        <Route path='/das' element={<Dashboard />}></Route>
        <Route path='/about' element={<About />}></Route>

    </Routes>
  )
}