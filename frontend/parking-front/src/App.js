import './App.css';
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom'
import Read from './components/Read/index';
import Create from './components/Create/index'
import CreateVehicle from './components/CreateVehicle';
import ReadVehicle from './components/ReadVehicle';


function App() {
  return (
    <Router>
      <div className="main">
        <h2 className="main-header">Parking Legal</h2>
        <div>
          <Link to="/create">Criar</Link> | <Link to="/read">Listar</Link> |
        </div>
          <br />
        <div>
          <Routes>
            <Route exact path='/read' element={<Read />} />
          </Routes>
        </div>
        <div>
          <Routes>
            <Route exact path='/create' element={<Create />} />
          </Routes>
        </div>
        <div>
          <Routes>
            <Route exact path='/createvehicle' element={<CreateVehicle />} />
          </Routes>
        </div>
        <div>
          <Routes>
            <Route exact path='/readvehicle' element={<ReadVehicle />} />
          </Routes>
        </div>
      </div>
    </Router>
  );
}

export default App;
