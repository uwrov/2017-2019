import React from "react";
import "./PlayerCards.css";
import Draggable from 'react-draggable';

class PlayerCards extends React.Component {

   //
   // Properties to be handling:
   // this.props.onSkipTurn:
   //
   render() {
      return (
         <div className="playerCards">
            {this.displayPlayerCards()}
         </div>
      );
   }

   displayPlayerCards = () => {
      if(this.props.playerCards instanceof Array) {

         return this.props.playerCards.map((card, index) => {
            return (
               <Draggable bounds="parent">
                  <div className="playerCard">
                     <h3>Company: {card.company}</h3>
                     <h4># of stocks: {card.amount}</h4>
                     <div
                        className="sellButton"
                        onClick={() => {this.handleSell(index)}}>
                        SELL!
                     </div>
                  </div>
               </Draggable>
            );
         });
      }
      return;
   }

   handleSell = (index) => {
      this.props.onSell(index);
   }
}

export default PlayerCards;
