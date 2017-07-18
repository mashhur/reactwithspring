// actions.js
export const activateTest = geod => ({
    type: 'ACTIVATE_TEST',
    geod,
});

export const closeTest = () => ({
    type: 'CLOSE_TEST',
});


function fetchUserListRequest(){
    return {
        type: "FETCH_REQUEST"
    }
}

function fetchUserListSuccess(payload) {
    return {
        type: "FETCH_SUCCESS",
        payload,
    }
}

function fetchUserListError() {
    return {
        type: "FETCH_ERROR"
    }
}

export function getUserList() {
    return (dispatch) => {
        dispatch(fetchUserListRequest());
        return fetchUserList().then(([response, json]) =>{
            if(response.status === 200){
                dispatch(fetchUserListSuccess(json))
                console.log(json);
            }
            else{
                dispatch(fetchUserListError())
            }
        })
    }
}

function fetchUserList() {
    const URL = "api/users";
    return fetch(URL, { method: 'GET'})
        .then( response => Promise.all([response, response.json()]));
}