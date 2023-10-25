import React, { useContext } from 'react';
import './Insights.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Chart as ChartJS, BarElement, CategoryScale, LinearScale, Tooltip, Legend, ArcElement } from 'chart.js';
import { Bar, Doughnut } from 'react-chartjs-2';
//import { Doughnut } from "react-chartjs-2";
import { ArrowDownward, ArrowUpward } from "@mui/icons-material";
ChartJS.register(BarElement, CategoryScale, LinearScale, Tooltip, Legend, ArcElement);
function Insights() {
    return (
      <div className="insights-body">
        <div className="container-fluid mt-4">
          <div className="card rounded">
            <div className="card-body">
              <div className="introduction card-body text-center">
                <h2>INSIGHTS</h2>
                <p style={{ padding: '10px' }}>A summary of the key observations from your chat with Helen.</p>
                <hr />
                <br />
                <div className="insightCard">
                  <div className="insightItem">
                    <span className="insightTitle">Social</span>
                    <div className="insightValueContainer" style={{ display: 'block', textAlign: 'center' }}>
                      <span className="insightValue" style={{ display: 'block', textAlign: 'center' }}>2%</span>
                      <span className="insightChangeRate" style={{ display: 'block', textAlign: 'center' }}>
                        -11.4 <ArrowDownward className="insightIcon negative" />
                      </span>
                    </div>
                    <span className="insightSub">Compared to last month</span>
                  </div>
                  <div className="insightItem">
                    <span className="insightTitle">Learning & Development</span>
                    <div className="insightValueContainer" style={{ display: 'block', textAlign: 'center' }}>
                      <span className="insightValue" style={{ display: 'block', textAlign: 'center' }}>10%</span>
                      <span className="insightChangeRate" style={{ display: 'block', textAlign: 'center' }}>
                        -1.4 <ArrowDownward className="insightIcon negative" />
                      </span>
                    </div>
                    <span className="insightSub">Compared to last month</span>
                  </div>
                  <div className="insightItem">
                    <span className="insightTitle">Support</span>
                    <div className="insightValueContainer" style={{ display: 'block', textAlign: 'center' }}>
                      <span className="insightValue" style={{ display: 'block', textAlign: 'center' }}>5%</span>
                      <span className="insightChangeRate" style={{ display: 'block', textAlign: 'center' }}>
                        +2.4 <ArrowUpward className="insightIcon" />
                      </span>
                    </div>
                    <span className="insightSub">Compared to last month</span>
                  </div>
                </div>
                <br />
              </div>
              <div className="content-after-title">
                <div className="container-lg my-4" style={{ backgroundColor: '#FDEFB2', padding: '20px', borderRadius: '10px' }}>
                  <div className="row">
                    <div className="col-md-8 mx-auto">
                      <div className="saved-notes-section">
                        <h2>Saved Notes</h2>
                        <div className="saved-notes"></div>
                       <button onClick={saveNote} style={{ marginTop: '1rem' }} className="btn btn-primary custom-save-button">Save Note</button>
                      </div>
                    </div>
                    <div className="col-md-4 mx-auto">
                      <div className="section-right">
                        <div className="notes-section">
                          <h2>Notes</h2>
                          <textarea id="notes" placeholder="Write your notes here..."></textarea>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
                <div className="row">
  <div className="col-sm-5 mx-auto">
    <div className="card custom-border">
      <div className="card-body">
        <h5 className="card-title">Most frequently used words</h5>
        <p className="card-text">Donec nec justo eget felis facilisis fermentum. Aliquam porttitor mauris sit amet orci. Aenean dignissim pellentesque felis.</p>
        <a href="#" className="btn btn-primary" style={{ backgroundColor: '#F18701', borderColor: '#F18701' }}>Share with someone</a>
      </div>
    </div>
  </div>
  <div className="col-sm-5 mx-auto">
    <div className="card custom-border">
      <div className="card-body">
        <h5 className="card-title">Actions Tracker</h5>
        <p className="card-text">Donec nec justo eget felis facilisis fermentum. Aliquam porttitor mauris sit amet orci. Aenean dignissim pellentesque felis.</p>
        <a href="#" className="btn btn-primary" style={{ backgroundColor: '#F18701', borderColor: '#F18701' }}>Share with someone</a>
      </div>
    </div>
  </div>
  <div className="col-sm-5 mx-auto">
    <div className="card custom-border">
      <div className="card-body">
        <h5 className="card-title">Sentiment Analysis</h5>
        <div style={{ height: '405px' }}>
          <Doughnut
            data={{
              labels: ["Happy", "Inspired", "Worry & Boredom", "Afraid"],
              datasets: [
                {
                  data: [30, 10, 50, 10],
                  backgroundColor: ["#3D348B", "#F35B04", "#F18701", "#F7B801"],
                  hoverBackgroundColor: ["#3D348B", "#F35B04", "#F18701", "#F7B801"]
                }
              ]
            }}
            options={{
              responsive: true
            }}
          />
        </div>
      </div>
    </div>
  </div>
  <div className="col-sm-5 mx-auto">
    <div className="card custom-border">
      <div className="card-body">
        <h5 className="card-title">Usage in the last quarter</h5>
        <div style={{ maxWidth: "650px" }}>
          <Bar
            data={{
              labels: ["Sept", "Oct", "Nov", "Dec"],
              datasets: [
                {
                  label: "total",
                  data: [1552, 1319, 613, 1400],
                  backgroundColor: ["#3D348B", "#F35B04", "#F18701", "#F7B801"],
                  borderColor: ["#3D348B", "#F35B04", "#F18701", "#F7B801"],
                  borderWidth: 0.5,
                },
              ],
            }}
            height={400}
            options={{
              maintainAspectRatio: false,
              scales: {
                y: {
                  beginAtZero: true,
                  ticks: {
                    stepSize: 500,
                  }
                },
              },
              legend: {
                labels: {
                  fontSize: 15,
                },
              },
            }}
          />
        </div>
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
  function saveNote() {
    var notes = document.getElementById("notes").value;
    if (notes.trim() !== "") {
      var savedNotes = document.querySelector(".saved-notes");
      var newNote = document.createElement("p");
      newNote.textContent = notes;
      savedNotes.appendChild(newNote);
      document.getElementById("notes").value = "";
    }
  }
  export default Insights;