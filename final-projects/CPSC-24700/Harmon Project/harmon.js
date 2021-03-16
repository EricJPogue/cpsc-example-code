/*  Eli Castillo
    Web and Distributed Programming
    Harmon js file
    12/17/20 */
const cards = document.querySelectorAll('.memory-card');

let hasFlippedCard = false;
let lockBoard = false;
let score = 0;
let firstCard, secondCard;

// this function flips a card after being clicked.
function flipCard() {
  if (lockBoard) return;
  if (this === firstCard) return;


  this.classList.add('flip');

  if (!hasFlippedCard) {
    // the first click of a card.
    hasFlippedCard = true;
    firstCard = this;
  } else {
    // the second click of a card.
    hasFlippedCard = false;
    secondCard = this;

    // do the two cards match?...
   if(firstCard.dataset.card === secondCard.dataset.card) {
     // When the two cards match...
     firstCard.removeEventListener('click', flipCard);
     secondCard.removeEventListener('click', flipCard);
     score += 100;
     console.log(score)
   } else {
     // When the two cards don't match...
     lockBoard = true;

     setTimeout(() => {
      firstCard.classList.remove('flip');
      secondCard.classList.remove('flip');

      resetBoard();
      lockBoard = false;
     }, 1500);
   }
  }
}

function resetBoard() {
  [hasFlippedCard, lockBoard] = [false, false];
  [firstCard, secondCard] = [null, null];
}

// shuffles cards every time site is refreshed.
(function shuffle() {
  cards.forEach(card => {
    let randomPosition = Math.floor(Math.random() * 12);
    card.style.order = randomPosition;
  });
})();

cards.forEach(card => card.addEventListener('click', flipCard))
  ;