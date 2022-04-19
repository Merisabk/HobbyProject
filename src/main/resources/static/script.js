import * as DOM from './dom.js'

// list recipe function
const writeRecipe = recipe => {
    const child = document.createElement(`li`);
    child.id = recipe._id;
    child.innerHTML = `${JSON.stringify(recipe)}`;
    DOM.listAllRecipes.appendChild(child);
}

//Get All function
const getAll = () => {
    DOM.listAllRecipes.innerHTML = ``;

    axios.get(`/getAll`)
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
    axios.post(`/create`, {    
                                name: DOM.inputRecipeName.value,
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