const toggleDarkMode = () => {
  const htmlElement = document.documentElement;
  htmlElement.classList.toggle('ion-palette-dark');
}

export { toggleDarkMode }
