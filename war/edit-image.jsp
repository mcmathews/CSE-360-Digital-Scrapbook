<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">

    <title>edit-image</title>

    <%@ include file="/include/cssimports.jsp" %>

        <script src="/js/lib/caman.full.js" type="text/javascript"></script>
        <script src="/js/profile.js" type="text/javascript"></script>
        <script src="/js/camanjs-script.js" type="text/javascript"></script>

        <link rel="stylesheet" type="text/css" href="/css/caman-edit-image-style.css" />
        <link rel="stylesheet" type="text/css" href="/css/main.css" />


</head>

<body>

    <%@ include file="/include/header.jsp" %>


        <div class="image-move"><img id="example" src="/image.jpg" /></div>
    
        <div id="Filters">
            
            
            
            
        <div class="col-md-6">
            <div class="Filter">
                <div class="FilterName">
                    <p>brightness</p>
                </div>

                <div class="FilterSetting">
                    <input type="range" min="-100" max="100" step="1" value="0" data-filter="brightness">
                    <span class="FilterValue">0</span>
                </div>
            </div>

            <div class="Filter">
                <div class="FilterName">
                    <p>contrast</p>
                </div>

                <div class="FilterSetting">
                    <input type="range" min="-100" max="100" step="1" value="0" data-filter="contrast">
                    <span class="FilterValue">0</span>
                </div>
            </div>

            <div class="Filter">
                <div class="FilterName">
                    <p>saturation</p>
                </div>

                <div class="FilterSetting">
                    <input type="range" min="-100" max="100" step="1" value="0" data-filter="saturation">
                    <span class="FilterValue">0</span>
                </div>
            </div>

            <div class="Filter">
                <div class="FilterName">
                    <p>vibrance</p>
                </div>

                <div class="FilterSetting">
                    <input type="range" min="-100" max="100" step="1" value="0" data-filter="vibrance">
                    <span class="FilterValue">0</span>
                </div>
            </div>

            <div class="Filter">
                <div class="FilterName">
                    <p>exposure</p>
                </div>

                <div class="FilterSetting">
                    <input type="range" min="-100" max="100" step="1" value="0" data-filter="exposure">
                    <span class="FilterValue">0</span>
                </div>
            </div>

            <div class="Filter">
                <div class="FilterName">
                    <p>hue</p>
                </div>

                <div class="FilterSetting">
                    <input type="range" min="0" max="100" step="1" value="0" data-filter="hue">
                    <span class="FilterValue">0</span>
                </div>
            </div>
</div>
            
<div class="col-md-6">

            <div class="Filter">
                <div class="FilterName">
                    <p>sepia</p>
                </div>

                <div class="FilterSetting">
                    <input type="range" min="0" max="100" step="1" value="0" data-filter="sepia">
                    <span class="FilterValue">0</span>
                </div>
            </div>

            <div class="Filter">
                <div class="FilterName">
                    <p>gamma</p>
                </div>

                <div class="FilterSetting">
                    <input type="range" min="0" max="10" step="0.1" value="0" data-filter="gamma">
                    <span class="FilterValue">0</span>
                </div>
            </div>

            <div class="Filter">
                <div class="FilterName">
                    <p>noise</p>
                </div>

                <div class="FilterSetting">
                    <input type="range" min="0" max="100" step="1" value="0" data-filter="noise">
                    <span class="FilterValue">0</span>
                </div>
            </div>

            <div class="Filter">
                <div class="FilterName">
                    <p>clip</p>
                </div>

                <div class="FilterSetting">
                    <input type="range" min="0" max="100" step="1" value="0" data-filter="clip">
                    <span class="FilterValue">0</span>
                </div>
            </div>

            <div class="Filter">
                <div class="FilterName">
                    <p>sharpen</p>
                </div>

                <div class="FilterSetting">
                    <input type="range" min="0" max="100" step="1" value="0" data-filter="sharpen">
                    <span class="FilterValue">0</span>
                </div>
            </div>

            <div class="Filter">
                <div class="FilterName">
                    <p>stackBlur</p>
                </div>

                <div class="FilterSetting">
                    <input type="range" min="0" max="20" step="1" value="0" data-filter="stackBlur">
                    <span class="FilterValue">0</span>
                </div>
            </div>
    </div>
            
            
            
        </div>

</body>

</html>
