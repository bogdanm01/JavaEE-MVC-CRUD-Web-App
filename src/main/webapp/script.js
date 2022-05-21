const alertElement = document.querySelector(".alert");
const submitBtnElement = document.querySelector("#submitFormButton");
const formElement = document.querySelector("#form");

const firstNameElement = document.querySelector("#firstName");
const lastNameElement = document.querySelector("#lastName");
const phoneElement = document.querySelector("#phone");
const emailElement = document.querySelector("#email");
const cityElement = document.querySelector("#city");

alertElement.style.display = "none";

submitBtnElement.addEventListener("click", () => {
  const firstName = firstNameElement.value;

  if (firstName.length > 0 && firstName !== "") formElement.submit();
  alertElement.style.display = "flex";
});
