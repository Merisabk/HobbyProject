"use strict"
import * as DOM from './dom.js'

// list recipe function
const writeRecipe = recipe => {
    const child = document.createElement(`li`);
    child.id = recipe._id;
    child.innerHTML = `${JSON.stringify(recipe)}`;
    DOM.listAllRecipes.appendChild(child);
}


//Get All function
const get = () => {
    DOM.listAllRecipes.innerHTML = ``;

    axios.get(`http://localhost:8080/getAll`)
    .then((response) => {
        console.log(response.data)
        myArray = response.data;
        buildTable(myArray)
        }
    ).catch((err) =>{
        console.log(err);
    });
}

let myArray = [];
// my table function 
const buildTable = (data) => {
    let table = DOM.myTable;
    for (let i = 0; i < data.length; i++) {
        let row = `<tr>
                        <td>${data[i].id}</td>
                        <td>${data[i].recipeName}</td>
                        <td>${data[i].category}</td>
                        <td>${data[i].servings}</td>
                        <td>${data[i].cookingTime}</td>
                        <td>${data[i].ingredients}</td>
                        </tr>`
            table.innerHTML += row;
    }

}

let writeSweet = [];
// my table function 
const buildTableSweet = (data) => {
    let table = DOM.myTable;

    for (let i = 0; i < data.length; i++) {
        let row = `<tr>
                        <td>${data[i].id}</td>
                        <td>${data[i].recipeName}</td>
                        <td>${data[i].category}</td>
                        <td>${data[i].servings}</td>
                        <td>${data[i].cookingTime}</td>
                        <td>${data[i].ingredients}</td>
                        </tr>`
            table.innerHTML += row
    }

}
// Get Sweet recipes 
const getSweet = () => {
    DOM.listAllRecipes.innerHTML = ``;

    axios.get(`http://localhost:8080/getByCategory/sweet`)
    .then((response) => {
        writeSweet = response.data;
        buildTable(writeSweet)
        console.log(writeSweet)
    }).catch((err) =>{
        console.log(err);
    });

    }


// get Savoury function 
const getSavoury = () => {
    DOM.listAllRecipes.innerHTML = ``;

    axios.get(`http://localhost:8080/getByCategory/savoury`)
    .then((response) => {
        myArray = response.data;
        buildTable(myArray)
        console.log(myArray)
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
        get();
    }).catch((err) => {
        console.log(err);
    });
}

//Put function 
const updateRecipe = () => {
    axios.put(`/update/${inputId.value}`, {
        recipeName: DOM.updateRecipeName.value,
                                category: DOM.updateCategory.value,
                                servings: DOM.updateServings.value,
                                cookingTime: DOM.updateCookingTime.value,
                                ingredients: DOM.updateIngredients.value})
    .then((response) => {
        get();
    }).catch((err) => {
        console.log(err);
    });
}

//delete function 
const deleteRecipe = () => {
    axios.delete(`/delete/${inputDelete.value}`)
    .then ((response) => {
        console.log(response);
        get();
      }).catch((err) => {
        console.log(err);
      })
        }



//buttons onclick 
DOM.buttonAddRecipe.onclick = () => post();
DOM.buttonSweet.onclick = () => getSweet();
DOM.buttonSavoury.onclick = () => getSavoury();
DOM.buttonAllRecipes.onclick = () => get();
DOM.buttonUpdate.onclick = () => updateRecipe();
DOM.buttonDelete.onclick = () => deleteRecipe(); 

