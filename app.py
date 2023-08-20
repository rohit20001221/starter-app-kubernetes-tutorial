from flask import Flask, render_template, jsonify, request
from flask_sqlalchemy import SQLAlchemy
from dataclasses import dataclass
import os

db_uri = (
    "postgresql://"
    + os.environ["POSTGRES_USER"]
    + ":"
    + os.environ["POSTGRES_PASSWORD"]
    + "@"
    + os.environ["POSTGRES_HOST"]
    + ":5432/"
    + os.environ["POSTGRES_DB"]
)

app = Flask(__name__)
app.config["SQLALCHEMY_DATABASE_URI"] = db_uri

db = SQLAlchemy(app)


@dataclass
class Item(db.Model):
    id: int
    title: str
    description: str

    id = db.Column(db.Integer, primary_key=True)
    title = db.Column(db.String, nullable=False)
    description = db.Column(db.String, nullable=False)


with app.app_context():
    db.create_all()


@app.route("/")
def index():
    return render_template("index.html"), 200


@app.route("/get-items")
def get_items():
    items = Item.query.all()

    return jsonify(items), 200


@app.route("/add-item", methods=["POST"])
def add_item():
    data = request.get_json()
    item = Item(title=data["title"], description=data["description"])

    db.session.add(item)
    db.session.commit()

    return jsonify({"success": True}), 200


@app.route("/delete-item/<int:id>", methods=["POST"])
def delete_item(id):
    item = db.get_or_404(Item, id)

    db.session.delete(item)
    db.session.commit()

    return jsonify({"success": True}), 200


if __name__ == "__main__":
    app.run(host="0.0.0.0", port=os.environ.get("PORT", 8000), debug=False)
