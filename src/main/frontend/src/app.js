import React from "react";
import ReactDOM from "react-dom";

const Hello = function(name) {
    return (
        <div>Hello, {name}</div>
    );
};

const view = Hello("World!");

const element = document.getElementById("react");
ReactDOM.render(view, element);