function submitForm(event, form) {
    event.preventDefault(); // prevent default form submission behavior

    const data = {
        post_id: form.querySelector('input[name="post_id"]').value,
        user_id: form.querySelector('input[name="user_id"]').value,
    };

    // make AJAX request to the server
    fetch(form.action, {
        method: form.method,
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data),
    })
    .then(response => {
        if (response.ok) {
            // update like count in the DOM

        }
    })
    .catch(error => console.error(error));
}