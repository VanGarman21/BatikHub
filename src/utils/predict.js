const tf = require('@tensorflow/tfjs-node');
const loadModel = require('../utils/loadModel');

const predictBatik = async (image) => {
    const model = await loadModel();

    const tensor = tf.node
    .decodeJpeg(image)
    .resizeNearestNeighbor([224, 224])
    .div(tf.scalar(255))
    .expandDims()
    .toFloat()

    const predicts = model.predict(tensor);
    const score = await predicts.data();
    const confidenceScore = Math.max(...score) * 100;
    class_names = ["Batik Bali", "Batik Betawi", "Batik Cendrawasih", "Batik Dayak", "Batik Geblek Renteng", "Batik Ikat Celup", "Batik Insang", "Batik Kawung", "Batik Lasem", "Batik Megamendung", "Batik Pala", "Batik Parang", "Batik Poleng", "Batik Sekar Jagad", "Batik Tambal"];

    const classResult = tf.argMax(predicts, 1).dataSync()[0];
    const label = class_names[classResult];

    const result = { confidenceScore, label }

    return result;
}

module.exports = predictBatik;