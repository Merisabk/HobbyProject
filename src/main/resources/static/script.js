import * as DOM from './dom.js'

// list recipe function
const writeRecipe = recipe => {
    const child = document.createElement(`li`);
    child.id = recipe._id;
    child.innerHTML = `${JSON.stringify(recipe)}`;
    DOM.listAllRecipes.appendChild(child);
}

// list sweet recipes function 
const writeSweetRecipe = recipe => {
    const child = document.createElement(`li`);
    child.category = recipe._category;
    child.innerHTML = `${JSON.stringify(recipe)}`;
    DOM.listSweetRecipes.appendChild(child);
}

//list savoury recipes function 
const writeSavouryRecipe = recipe => {
    const child = document.createElement(`li`);
    child.id = recipe._id;
    child.innerHTML = `${JSON.stringify(recipe)}`;
    DOM.listSavouryRecipes.appendChild(child);
}

//Get All function
const get = () => {
    DOM.listAllRecipes.innerHTML = ``;

    axios.get(`http://localhost:8080/getAll`)
    .then((response) => {
        if (!Array.isArray(response.data)) {
            writeRecipe(response.data);
        } else {
            for (let recipe of response.data) {
                writeRecipe(recipe);
            }
        }
    }).catch((err) =>{
        console.log(err);
    });
}

// Get Sweet recipes 
const getSweet = () => {
    DOM.listSweetRecipes.innerHTML = ``;

    axios.get(`http://localhost:8080/getByCategory/${buttonSweet.category}`)
    .then((response) => {
        if (!Array.isArray(response.data)) {
            writeRecipe(response.data);
        } else {
            for (let recipe of response.data) {
                writeRecipe(recipe);
            }
        }
    }).catch((err) =>{
        console.log(err);
    });

    }



// post function
const post = () => {
    axios.post(`http://localhost:8080/create`, {    
                                recipeName: DOM.inputRecipeName.value,
                                category: DOM.inputCategory.value,
                                servings: DOM.inputServings.value,
                                cookingTime: DOM.inputCookingTime.value,
                                ingredients: DOM.inputIngredients.value})
    .then((response) => {
        console.log(response);
        getAll();
    }).catch((err) => {
        console.log(err);
    });
}



//buttons onclick 
DOM.buttonAddRecipe.onclick = () => post();
DOM.buttonSweet.onclick = () => getSweet();

//run the getAll function on page load
get();