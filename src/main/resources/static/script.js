"use strict"
import * as DOM from './dom.js'

// list recipe function
const writeRecipe = recipe => {
    const child = document.createElement(`li`);
    child.id = recipe._id;
    child.innerHTML = `${JSON.stringify(recipe)}`;
    DOM.listAllRecipes.appendChild(child);
}


// display img function
// const displayImage = () => {
// let uploadedImage = "";
// DOM.inputImage.addEventListener("change", function(e){
//     const reader = new FileReader();
//     reader.onload = function() {
//         const img = new Image();
//         img.src = reader.result;
//         uploadedImage = img;
//     };
    // reader.addEventListener("load", () => {
    //     console.log(reader.result);
    //     uploadedImage = reader.result;
    //     DOM.displayImage = `url${uploadedImage}`;
    // });
//     reader.readAsDataURL(this.files[0]);
// }, false);
// }

//Get All function
const get = () => {
    axios.get(`/getAll`)
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
    table.innerHTML = ``;
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

// Get Sweet recipes 
const getSweet = () => {
    axios.get(`/getByCategory/sweet`)
    .then((response) => {
        myArray = response.data;
        buildTable(myArray)
        console.log(myArray)
    }).catch((err) =>{
        console.log(err);
    });

    }


// get Savoury function 
const getSavoury = () => {
    axios.get(`/getByCategory/savoury`)
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
    axios.post(`/create`, {    
                                recipeName: DOM.inputRecipeName.value,
                                category: DOM.inputCategory.value,
                                servings: DOM.inputServings.value,
                                cookingTime: DOM.inputCookingTime.value,
                                ingredients: DOM.inputIngredients.value
                            })
    .then((response) => {
        get();
    }).catch((err) => {
        console.log(err);
    });
}

//Put function 
const updateRecipe = () => {
    axios.put(`/update/${inputRecipeId.value}`, {
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

get();

let inputs = document.querySelectorAll(`input`);
DOM.buttonAddRecipe.addEventListener('click', () => {
    inputs.forEach(input => input.value = '');
});

DOM.buttonUpdate.addEventListener('click', () => {
    inputs.forEach(input => input.value = '');
});

DOM.buttonDelete.addEventListener('click', () => {
    inputs.forEach(input => input.value = '');
});