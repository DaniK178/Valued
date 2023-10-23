import 'bootstrap/dist/css/bootstrap.min.css';

function Footer() {
  return (
    <footer style={{ backgroundColor: '#3D348B', position: 'fixed', bottom: '0', width: '100%', zIndex: '1000' }} className="text-light text-center py-3">
      <div className="container">
        <p className="mb-0">&copy; 2023 Valued. All rights reserved.</p>
      </div>
    </footer>
  );
}

export default Footer;