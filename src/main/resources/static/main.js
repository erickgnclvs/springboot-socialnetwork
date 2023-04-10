function submitLikeForm(event, form) {
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
            const likeCount = form.closest('.post').querySelector('.like-count');
            const newCount = parseInt(likeCount.textContent) + 1;
            likeCount.textContent = newCount;

        }
    })
    .catch(error => console.error(error));
}

function submitPostForm(event, form) {
    event.preventDefault(); // prevent default form submission behavior

    const data = {
        content: form.querySelector('textarea[name="content"]').value,
        userId: form.querySelector('input[name="userId"]').value,
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

            // do something
            location.reload();

        }
    })
    .catch(error => console.error(error));
}


// TODO: Fix htmls to use this js instead of inline