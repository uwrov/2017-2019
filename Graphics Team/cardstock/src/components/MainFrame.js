import React from "react";

class MainFrame extends React.Component {
   state = {
      currentPlayer: {
         name: "Bob",
         money: 13,
         stock: [
            { company: "Gooble", stock: 3, price: 0 },
            { company: "Amazoom", stock: 1, price: 0 },
         ]
      },
      players: [
         { name: "Bob", money: 13, stock: [
               { company: "Gooble", stock: 3, price: 0 },
               { company: "Amazoom", stock: 1, price: 0 },
            ]},
         { name: "Dad", money: 9, stock: [
               { company: "Macrosoft", stock: 3, price: 0 },
               { company: "Amazoom", stock: 2, price: 0 },
               { company: "Amazoom", stock: 1, price: 0 },
            ]},
         { name: "Chris", money: 23, stock: [
               { company: "Gooble", stock: 2, price: 0 },
            ]},
      ],
      stock_market: {
         "Gooble": 10
         "Amazoom": 15
         "Macrosoft": 13
      },
      turn: 3,
      current_market: [
         { company: "Gooble", stock: 3, price: 21 },
         { company: "Gooble", stock: 1, price: 10 },
         { company: "Amazoom", stock: 2, price: 24 },
         { company: "Macrosoft", stock: 3, price: 28 },
         { company: "Amazoom", stock: 1, price: 15 },
      ]
   }

   render() {
      return (
         <div>
         </div>
      );
   }


}
