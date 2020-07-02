import React from 'react';
import Lobby from './lobby/Lobby.js';
import MainFrame from './components/MainFrame';
import Results from './results/Results';

class ComponentHandler extends React.Component {
   state = {
      id: null,
      socket: null,
      gameStart: false,
      showResults: false
   }

   constructor(props) {
      super(props);

      this.state.socket = require('socket.io-client')('http://localhost:4000');

      let id = window.localStorage.getItem("id");
      if(id === null) {
         this.state.socket.emit("Generate ID");
      } else {
         id = parseInt(id);
         this.state.socket.emit("Previous ID", id);
      }
      this.state.socket.on("ID Confirm", this.setID);
      this.state.socket.on("Game State", this.checkState);
   }

   setID = (id) => {
      window.localStorage.setItem("id", id);
      console.log("id: " + id);
      this.setState( { "id": id } );
   }

   checkState = (data) => {
      this.setState( {gameStart: data.state} );
   }

   componentDidMount(){
      this.state.socket.emit("Update Request");
   }

   render() {
      return (
         <div>
            {this.displayGame()}
            {this.displayLobby()}
            {this.displayResults()}
         </div>
      );
   }

   displayGame() {
      if(this.state.gameStart)
         return <MainFrame socket={this.state.socket} id={this.state.id}/>
   }

   displayLobby() {
      if(!this.state.gameStart)
         return <Lobby socket={this.state.socket} id={this.state.id} />;
   }

   displayResults() {
      if(this.state.showResults && this.state.gameStart)
         return <Results socket={this.state.socket} id={this.state.id} />;
   }
}

export default ComponentHandler;
