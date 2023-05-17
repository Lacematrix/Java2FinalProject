document.write("<script src='../js/wordcloud-demo.js'></script>");
document.write("<script src='../js/piechart-demo.js'></script>");
document.write("<script src='../js/Chart.js'></script>");
document.write("<script src='../js/Data.js'></script>");

function getAnswerNumber() {
    const percentage = getData('NoAnswer');
    const AvgAndMax = getData('AvgAndMax');
    const Distribution = getData('Distribution');
    //console.log(percentage)
    creatPiechart('left-answer', Distribution, 'distribution of the number');
    creatRedHistogram('center-top-answer', AvgAndMax, 'avg and max');
    creatHistogram('center-bottom-answer', percentage, ' noAccept And Accept');
}

function getAcceptAnswer() {
    creatWordCloud('left-answer', wordcloudRaw);
}

function getTags() {

}

function getUsers() {

}