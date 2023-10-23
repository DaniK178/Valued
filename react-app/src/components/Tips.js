import './Tips.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import social from '../Images/tips1.jpg';
import landd from '../Images/tips2.jpg';
import support from '../Images/tips3.jpg';

function Tips() {
  return (
    <div className="tips-body">
      <div className="container-fluid mt-4">
        <div className="introduction card-body text-center">
          <h2>TIPS</h2>
          <p style={{ padding: '10px' }}>
            Below you will find some recommendations based on our conversation.
            <br />Some more text
          </p>
          <hr />
          <div className="content d-flex justify-content-center">
            <div className="row card-container">
              <div className="col-md-4">
                <div className="flip-card card-body text-center">
                  <div className="flip-card-inner">
                    <div className="flip-card-front">
                      <img
                        src={social}
                        alt="social logo"
                        style={{ maxWidth: '100%' }}
                      />
                    </div>
                    <div className="flip-card-back">
                      <h1>Social Tips</h1>
                      <p className="card-text">
                        <br />This is some content for the first column.
                      </p>
                    </div>
                  </div>
                </div>
              </div>
              <div className="col-md-4">
                <div className="flip-card card-body text-center">
                  <div className="flip-card-inner">
                    <div className="flip-card-front">
                      <img
                        src={landd}
                        alt="l&d logo"
                        style={{ maxWidth: '100%' }}
                      />
                    </div>
                    <div className="flip-card-back">
                      <h1>Learning Development Tips</h1>
                      <p className="card-text">
                        <br />This is some content for the first column.
                      </p>
                    </div>
                  </div>
                </div>
              </div>
              <div className="col-md-4">
                <div className="flip-card card-body text-center">
                  <div className="flip-card-inner">
                    <div className="flip-card-front">
                      <img
                        src={support}
                        alt="support logo"
                        style={{ maxWidth: '100%' }}
                      />
                    </div>
                    <div className="flip-card-back">
                      <h1>Support Tips</h1>
                      <p className="card-text">
                        <br />This is some content for the first column.
                      </p>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Tips;