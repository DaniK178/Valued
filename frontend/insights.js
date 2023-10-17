function saveNote() {
    var notes = document.getElementById("notes").value;
    if (notes.trim() !== "") {
        var savedNotes = document.querySelector(".saved-notes");
        var newNote = document.createElement("p");
        newNote.textContent = notes;
        savedNotes.appendChild(newNote);
        document.getElementById("notes").value = "";
    }
}