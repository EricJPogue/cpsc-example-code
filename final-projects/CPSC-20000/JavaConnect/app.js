//Brenden Kelley

const allCells = document.querySelectorAll('.cell:not(.row-top)');
const topCells = document.querySelectorAll('.cell.row-top');
const resetButton = document.querySelector('.reset');
const statusSpan = document.querySelector('.status');

const column0 = [allCells[35], allCells[28], allCells[21], allCells[14], allCells[7], allCells[0], topCells[0]];
const column1 = [allCells[36], allCells[29], allCells[22], allCells[15], allCells[8], allCells[1], topCells[1]];
const column2 = [allCells[37], allCells[30], allCells[23], allCells[16], allCells[9], allCells[2], topCells[2]];
const column3 = [allCells[38], allCells[31], allCells[24], allCells[17], allCells[10], allCells[3], topCells[3]];
const column4 = [allCells[39], allCells[32], allCells[25], allCells[18], allCells[11], allCells[4], topCells[4]];
const column5 = [allCells[40], allCells[33], allCells[26], allCells[19], allCells[12], allCells[5], topCells[5]];
const column6 = [allCells[41], allCells[34], allCells[27], allCells[20], allCells[13], allCells[6], topCells[6]];
const columns = [column0, column1, column2, column3, column4, column5, column6];

const topRow = [topCells[0], topCells[1], topCells[2], topCells[3], topCells[4], topCells[5], topCells[6]];
const row0 = [allCells[0], allCells[1], allCells[2], allCells[3], allCells[4], allCells[5], allCells[6]];
const row1 = [allCells[7], allCells[8], allCells[9], allCells[10], allCells[11], allCells[12], allCells[13]];
const row2 = [allCells[14], allCells[15], allCells[16], allCells[17], allCells[18], allCells[19], allCells[20]];
const row3 = [allCells[21], allCells[22], allCells[23], allCells[24], allCells[25], allCells[26], allCells[27]];
const row4 = [allCells[28], allCells[29], allCells[30], allCells[31], allCells[32], allCells[33], allCells[34]];
const row5 = [allCells[35], allCells[36], allCells[37], allCells[38], allCells[39], allCells[40], allCells[41]];
const rows = [row0, row1, row2, row3, row4, row5, topRow];


//We need a couple of booleans that flip between false and true to determine game state and who's turn it is.
let gamePlaying = true;
let redTurn = true;


// Functions
//the class list of a cell is not actually an array, this makes it an actual array
function getClassListArray(cell) {
    const classList = cell.classList;
    return [...classList];
}

//gets the location on the grid of the cell that was clicked
function getCellLoc(cell) {
    const classList = getClassListArray(cell);

    const rowClass = classList.find(className => className.includes('row'));
    const colClass = classList.find(className => className.includes('col'));
    const rowIndex = rowClass[4];
    const colIndex = colClass[4];

    return [parseInt(rowIndex, 10), parseInt(colIndex, 10)];
}

//Checks each column from bottom to top to see if it is filled
function checkOpenCol(colIndex) {
    const column = columns[colIndex];
    const columnGrid = column.slice(0, 6);

    for (const cell of columnGrid) {
        const classList = getClassListArray(cell);
        if (!classList.includes('red') && !classList.includes('black')) {
            return cell;
        }
    }

    return null;
}

//clears the top row, which is just an indicator row
function clearTop(colIndex) {
    const topCell = topCells[colIndex];
    topCell.classList.remove('red');
    topCell.classList.remove('black');
}

//Gets the color of the cell being checked at this time
function cellColor(cell) {
    const classList = getClassListArray(cell);
    if (classList.includes('red'))
        return 'red';
    if (classList.includes('black'))
        return 'black';
    return null;
}

//checks each win to determine if there are 4 in a row
function checkWinningCells(cells) {
    if (cells.length < 4)
        return false;

    gamePlaying = false;
    for (const cell of cells) {
        cell.classList.add('win');
    }
    statusSpan.textContent = `${redTurn ? 'Red' : 'Black'} has won!`;
    return true;
}

//Checks Who won the game, check runs after every chip is dropped
function checkStatusOfGame(cell) {
    const color = cellColor(cell);
    if (!color)
        return;
    const [rowIndex, colIndex] = getCellLoc(cell);

    // Check horizontally
    let winningCells = [cell];
    let rowCheck = rowIndex;
    let colCheck = colIndex - 1;
    while (colCheck >= 0) {
        const cellCheck = rows[rowCheck][colCheck];
        if (cellColor(cellCheck) === color) {
            winningCells.push(cellCheck);
            colCheck--;
        } else {
            break;
        }
    }
    colCheck = colIndex + 1;
    while (colCheck <= 6) {
        const cellCheck = rows[rowCheck][colCheck];
        if (cellColor(cellCheck) === color) {
            winningCells.push(cellCheck);
            colCheck++;
        } else {
            break;
        }
    }
    let isWinningCombo = checkWinningCells(winningCells);
    if (isWinningCombo)
        return;


    // Check vertically
    winningCells = [cell];
    rowCheck = rowIndex - 1;
    colCheck = colIndex;
    while (rowCheck >= 0) {
        const cellCheck = rows[rowCheck][colCheck];
        if (cellColor(cellCheck) === color) {
            winningCells.push(cellCheck);
            rowCheck--;
        } else {
            break;
        }
    }
    rowCheck = rowIndex + 1;
    while (rowCheck <= 5) {
        const cellCheck = rows[rowCheck][colCheck];
        if (cellColor(cellCheck) === color) {
            winningCells.push(cellCheck);
            rowCheck++;
        } else {
            break;
        }
    }
    isWinningCombo = checkWinningCells(winningCells);
    if (isWinningCombo)
        return;


    // Check diagonally /
    winningCells = [cell];
    rowCheck = rowIndex + 1;
    colCheck = colIndex - 1;
    while (colCheck >= 0 && rowCheck <= 5) {
        const cellCheck = rows[rowCheck][colCheck];
        if (cellColor(cellCheck) === color) {
            winningCells.push(cellCheck);
            rowCheck++;
            colCheck--;
        } else {
            break;
        }
    }
    rowCheck = rowIndex - 1;
    colCheck = colIndex + 1;
    while (colCheck <= 6 && rowCheck >= 0) {
        const cellCheck = rows[rowCheck][colCheck];
        if (cellColor(cellCheck) === color) {
            winningCells.push(cellCheck);
            rowCheck--;
            colCheck++;
        } else {
            break;
        }
    }
    isWinningCombo = checkWinningCells(winningCells);
    if (isWinningCombo)
        return;


    // Check diagonally \
    winningCells = [cell];
    rowCheck = rowIndex - 1;
    colCheck = colIndex - 1;
    while (colCheck >= 0 && rowCheck >= 0) {
        const cellCheck = rows[rowCheck][colCheck];
        if (cellColor(cellCheck) === color) {
            winningCells.push(cellCheck);
            rowCheck--;
            colCheck--;
        } else {
            break;
        }
    }
    rowCheck = rowIndex + 1;
    colCheck = colIndex + 1;
    while (colCheck <= 6 && rowCheck <= 5) {
        const cellCheck = rows[rowCheck][colCheck];
        if (cellColor(cellCheck) === color) {
            winningCells.push(cellCheck);
            rowCheck++;
            colCheck++;
        } else {
            break;
        }
    }
    isWinningCombo = checkWinningCells(winningCells);
    if (isWinningCombo)
        return;

    // Check to see if we have a tie
    const rowsGrid = rows.slice(0, 6);
    for (const row of rowsGrid) {
        for (const cell of row) {
            const classList = getClassListArray(cell);
            if (!classList.includes('red') && !classList.includes('black')) {
                return;
            }
        }
    }

    gamePlaying = false;
    statusSpan.textContent = "Game is a tie!";
}

//Finds out if mouse if hovering over a cell and puts a chip on the top row for user.
function handleCellMouseOver(e) {
    if (!gamePlaying)
        return;
    const cell = e.target;
    const [rowIndex, colIndex] = getCellLoc(cell);

    const topCell = topCells[colIndex];
    topCell.classList.add(redTurn ? 'red' : 'black');
}

//Removes Chip from top if mouse stops hovering over a column
function handleCellMouseOut(e) {
    const cell = e.target;
    const [rowIndex, colIndex] = getCellLoc(cell);
    clearTop(colIndex);
}

//Puts a chip at the bottom most available row in the column clicked.
function handleCellClick(e) {
    if (!gamePlaying)
        return;
    const cell = e.target;
    const [rowIndex, colIndex] = getCellLoc(cell);

    const openCell = checkOpenCol(colIndex);

    if (!openCell)
        return;

    openCell.classList.add(redTurn ? 'red' : 'black');
    checkStatusOfGame(openCell);

    redTurn = !redTurn;
    clearTop(colIndex);
    if (gamePLaying) {
        const topCell = topCells[colIndex];
        topCell.classList.add(redTurn ? 'red' : 'black');
    }
}

//This loop calls the previous 3 functions when the criteria is met (mouseover, mouseout, click)
for (const row of rows) {
  for (const cell of row) {
    cell.addEventListener('mouseover', handleCellMouseOver);
    cell.addEventListener('mouseout', handleCellMouseOut);
    cell.addEventListener('click', handleCellClick);
  }
}

//The reset button
resetButton.addEventListener('click', () => {
  for (const row of rows) {
    for (const cell of row) {
      cell.classList.remove('black');
      cell.classList.remove('red');
      cell.classList.remove('win');
    }
  }
  gamePlaying = true;
  redTurn = true;
  statusSpan.textContent = '';
});