import Carousel from 'react-bootstrap/Carousel';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min.js';
import helen from '../Images/Helen.jpg';
import landd from '../Images/L&D.jpg';
import social from '../Images/Social.jpg';
import support from '../Images/Support.jpg';
import './HomePage.css'

function HomePage() {
    return (
      <div className="homePage">
        <Carousel>
            <Carousel.Item>
                <img className="d-block w-100" src={helen} alt="First slide" />
            </Carousel.Item>
            <Carousel.Item>
                <img className="d-block w-100" src={landd} alt="Second slide" />
            </Carousel.Item>
            <Carousel.Item>
                <img className="d-block w-100" src={social} alt="Third slide" />
            </Carousel.Item>
            <Carousel.Item>
                <img className="d-block w-100" src={support} alt="Fourth slide" />
            </Carousel.Item>
        </Carousel>
      </div>
    );
}

export default HomePage;