document.write("<script src='../js/Chart.js'></script>");
document.write("<script src='../js/Data.js'></script>");

function getAnswerNumber() {
    const percentage = getData('/Question/NoAnswer');
    const AvgAndMax = getData('/Question/AvgAndMax');
    const Distribution = getData('/Question/Distribution');
    //console.log(percentage)
    creatPiechart('left-answer', Distribution, 'distribution of the number');
    creatRedHistogram('center-top-answer', AvgAndMax, 'avg and max', '/p');
    creatHistogram('center-bottom-answer', percentage, ' noAnswer And Answer', '%');
}

function getAcceptAnswer() {
    const percentage = getData('/Answer/PercentageOfAccept');
    const resolve = getData('/Answer/ResolutionTime');
    const moreUpvote = getData('/Answer/MoreUpvote');
    creatPiechart('center-top-answer', resolve, 'ResolvedTime');
    creatHistogram('left-answer', percentage, 'PercentageOfAccept', '%')
    creatHistogramAnimation('center-bottom-answer', moreUpvote, '% of more upvote than accepted answers', '%');
}

function getTags() {

}

function getUsers() {

}