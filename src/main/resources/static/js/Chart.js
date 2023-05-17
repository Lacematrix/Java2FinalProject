document.write(
    "<script src='https://cdn.jsdelivr.net/npm/echarts@5/dist/echarts.min.js'></script>")
document.write(
    "<script src='https://cdn.jsdelivr.net/npm/echarts-wordcloud@2/dist/echarts-wordcloud.min.js'></script>")

//resize问题
function creatPiechart(div, piechartRaw, name) {
    let piechart = echarts.init(document.getElementById(div));
    let piechartData = [];
    for (const key in piechartRaw) {
        piechartData.push({
            name: key,
            value: piechartRaw[key]
        });
    }
    let pieOption = {
        title: {
            text: name,
            textStyle: {
                fontStyle: 'oblique',
                fontSize: 20,
                color: '#4cc9f0'
            },
            left: 'center'
        },
        tooltip: {
            trigger: 'item'
        },
        grid: {
            width: '100%',
            height: '100%'
        },
        legend: {
            orient: 'vertical',
            textStyle: {
                fontSize: 20,
                color: 'black'
            },
            right: 'center',
            bottom: 'bottom',
        },
        series: [
            {
                name: 'Problem Count',
                type: 'pie',
                radius: '80%',
                data: piechartData,
                color: ['#9400D3', '#FF00FF', '#4169E1', '#3CB371',
                    '#FFA500', '#FF7F50', '#DC143C', '#000080'],
                emphasis: {
                    itemStyle: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0.1, 0.2, 0, 0.5)',
                    }
                },
                itemStyle: {
                    normal: {
                        label: {
                            textStyle: {
                                fontSize: 12,
                                color: 'black'
                            }
                        }
                    }
                }
            }
        ]
    };
    piechart.setOption(pieOption)
    window.onresize = piechart.resize;
}

function creatWordCloud(div, wordcloudRaw, name) {
    let wordcloud = echarts.init(document.getElementById(div));
    let wordcloudData = [];
    for (const key in wordcloudRaw) {
        wordcloudData.push({
            name: key,
            value: wordcloudRaw[key]
        });
    }
    let wordcloudOption = {
        title: {
            text: name,
            textStyle: {
                fontStyle: 'oblique',
                fontSize: 20,
                color: '#4cc9f0'
            },
            left: 'center'
        },
        tooltip: {},
        series: [{
            type: 'wordCloud',
            shape: {
                cloudGrow: 0.2
            },
            sizeRange: [10, 60],
            rotationRange: [-30, 30],
            gridSize: 2,
            drawOutOfBound: false,
            layoutAnimation: true,
            keepAspect: true,
            textStyle: {
                fontWeight: 'bold',
                color: function () {
                    return 'rgb(' + [
                        Math.round(Math.random() * 160),
                        Math.round(Math.random() * 160),
                        Math.round(Math.random() * 160)
                    ].join(',') + ')';
                }
            },
            emphasis: {
                textStyle: {
                    shadowBlur: 15,
                    shadowColor: '#333'
                }
            },
            data: wordcloudData.sort(function (a, b) {
                return b.value - a.value;
            })
        }]
    };
    wordcloud.setOption(wordcloudOption);
    window.onresize = wordcloud.resize;
}

function creatHistogram(div, data, name) {
    let histogram = echarts.init(document.getElementById(div));
    let key = Object.keys(data);
    let value = Object.values(data);
    let allData = [];
    for (let i = 0; i < key.length; i++) {
        allData.push({
            name: key[i],
            type: 'bar',
            data: [value[i]]
        })
    }
    let histogramOption = {
        title: {
            text: name,
            textStyle: {
                fontStyle: 'oblique',
                fontSize: 20,
                color: '#4cf04f'
            },
        },
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            itemGap: 40,
            data: [key]
        },
        calculable: true,
        xAxis: [{
            type: 'category',
            data: [key]
        }],
        yAxis: [{
            type: 'value',
            axisLabel: {
                formatter: '{value} %'
            }
        }],
        series: allData
        // series: [
        //   // {
        //   //   name: key[0],
        //   //   type: 'bar',
        //   //   data: [value[0]],
        //   //   // markPoint: {
        //   //   //   data: [
        //   //   //     {type: 'max', name: '最大值'},
        //   //   //     {type: 'min', name: '最小值'}]
        //   //   // }
        //   // },
        //   // {
        //   //   name: key[1],
        //   //   type: 'bar',
        //   //   data: [value[1]],
        //   //   // markPoint: {
        //   //   //   data: [
        //   //   //     {type: 'min', name: '周最低'}]
        //   //   // }
        //   // }
        // ]
    };
    histogram.setOption(histogramOption);
    window.onresize = histogram.resize;
}
function creatRedHistogram(div, data, name) {
    let histogram = echarts.init(document.getElementById(div));
    let key = Object.keys(data);
    let value = Object.values(data);
    let allData = [];
    for (let i = 0; i < key.length; i++) {
        allData.push({
            name: key[i],
            type: 'bar',
            color: 'rgb(255,0,0)',
            data: [value[i]],
            showBackground: true,
            backgroundStyle: {
                color: 'rgba(220, 220, 220, 0.8)'
            }
        })
    }
    let histogramOption = {
        title: {
            text: name,
            textStyle: {
                fontStyle: 'oblique',
                fontSize: 20,
                color: '#624cf0'
            },
        },
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            itemGap: 40,
            data: [key]
        },
        calculable: true,
        xAxis: [{
            type: 'category',
            data: [key]
        }],
        yAxis: [{
            type: 'value',
            axisLabel: {
                formatter: '{value} '
            }
        }],
        series: allData
    }
    histogram.setOption(histogramOption);
    window.onresize = histogram.resize;
}


